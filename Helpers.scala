package helpers

abstract class Factoring {
	val n: Long

	def factors: Iterable[Long]

	lazy val isPrime = factors.size == 1

	lazy val factor: Map[Long, Int] =
		factors.groupBy(identity).mapValues(_.size)

	lazy val divisors: Seq[Long] = {
		def aux(l: List[(Long, Int)]): Seq[Long] = l match {
			case (p, times) :: tail =>
				for {
					cur <- aux(tail)
					i <- 0 to times
					factor = math.pow(p, i).toLong
				} yield cur * factor
			case _ => Seq(1)
		}
		aux(factor.toList)
	}
	
	lazy val divisorCount: Int = factor.map(_._2 + 1).product

	lazy val divisorSum: Long = factor.map { case (p, times) =>
		(math.pow(p, times+1).toLong - 1)/(p - 1)
	}.product
}

case class SysFactoring(n: Long) extends Factoring {
	import scala.sys.process._

	lazy val factors =
		Seq("factor", n.toString).!!.trim.split(" +").toList.tail.map(_.toLong)
}

case class NativeFactoring(n: Long) extends Factoring {
	lazy val factors = {
		var result = List.empty[Long]
		var num = n

		var cur = 2
		while (cur <= n/cur) {
			while(num % cur == 0) {
				result ::= cur
				num /= cur
			}
			cur += 1
		}
		if (num > 1)
			result ::= num

		result.sorted
	}
}

case class MultiFactoring(n: Int) {
	val sieve = Sieve(n)
	var table = Array.fill(n+1)(List.empty[Int])
	
	for {
		prime <- sieve.primesIter().dropWhile(_ <= 7)
		i <- prime to n by prime
	} table(i) ::= prime

	def totient(i: Int) = {
		var result = i
		
		if (i % 2 == 0)
			result /= 2
		if (i % 3 == 0) {
			result /= 3
			result *= 2
		}
		if (i % 5 == 0) {
			result /= 5
			result *= 4
		}
		if (i % 7 == 0) {
			result /= 7
			result *= 6
		}
		
		table(i).foreach { p =>
			result /= p
			result *= p - 1
		}

		result
	}
}


case class Sieve(n: Int) {
	private val size = (n - 3) / 2

	private val sieve =
		collection.mutable.BitSet() ++ (0 to size)

	private val root = (math.sqrt(n).toInt - 3) / 2
	for {
		i <- 0 to root
		if sieve(i)
		p = 2*i + 3
		j <- i*(p+3)+3 to size by p
	} sieve(j) = false

	lazy val primes: IndexedSeq[Int] =
		2 +: sieve.toVector.map(2*_ + 3)

	lazy val totients: IndexedSeq[Int] = {
		val table = Array.tabulate(n + 1)( i =>
			if (i % 2 == 0) i / 2 else i
		)
		for {
			i <- sieve
			p = 2*i + 3
			m <- p to n by p
		} table(m) = table(m) / p * (p - 1)
		table
	}

	def isPrime(num: Long): Boolean =
		if (num <= 2)
			num == 2
		else if (num <= n)
			num%2 == 1 && sieve(((num - 3) / 2).toInt)
		else if (num <= n.toLong*n) {
			val root = math.sqrt(num).toInt
			primes.takeWhile(_ <= root).forall(num % _ != 0)
		} else throw new Exception(s"Cannot check $num for primality in sieve of size $n.")

	def primeCount(num: Int): Int = {
		import collection.Searching._

		primes.search(num) match {
			case Found(i) => i + 1
			case InsertionPoint(i) => i
		}
	}

	def primesIter(from: Int = 2): Iterator[Int] = {
		val it = sieve.iteratorFrom(((from - 2) / 2).toInt).map(2*_ + 3)
		if (from > 2) it else Iterator(2) ++ it
	}

	def oddCompositesIter(from: Int = 9): Iterator[Int] =
		(((from - 2) / 2).toInt to size).iterator.filterNot(sieve).map(2*_ + 3)
}

object Helpers {
	def binoms(n: Int) = {
		def aux(r: Int, acc: BigInt): Stream[BigInt] =
			if (r > n)
				Stream(1)
			else
				acc #:: aux(r+1, acc*(n+1-r)/r)

		aux(1, 1)
	}

	def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a%b)
		
	def reverse(num: Int) = {
		var n = num
		val result = 0
		while(n != 0) {
			result *= 10
			result += n % 10
			n /= 10
		}
		result
	}
}

object SumOfTotients {
	var memo = Map(BigInt(1) -> BigInt(0))
	
	def upTo(n: BigInt): BigInt = memo.getOrElse(n, {
		var sum = n * (n-1) / 2
		var m = BigInt(2)
		while (true) {
			val m2 = n / (n / m)
			if (m2 >= n) {
				val result = sum - (n - m + 1) * upTo(n / m)
				memo += n -> result
				return result
			}
			sum -= (m2 - m + 1) * upTo(n / m)
			m = m2 + 1
		}
		-1
	})
}