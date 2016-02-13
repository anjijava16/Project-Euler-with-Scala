val table = Vector(
	"H"  -> (Seq("H"), "22"),
	"He" -> (Seq("Hf", "Pa", "H", "Ca", "Li"), "13112221133211322112211213322112"),
	"Li" -> (Seq("He"), "312211322212221121123222112"),
	"Be" -> (Seq("Ge", "Ca", "Li"), "111312211312113221133211322112211213322112"),
	"B"  -> (Seq("Be"), "1321132122211322212221121123222112"),
	"C"  -> (Seq("B"), "3113112211322112211213322112"),
	"N"  -> (Seq("C"), "111312212221121123222112"),
	"O"  -> (Seq("N"), "132112211213322112"),
	"F"  -> (Seq("O"), "31121123222112"),
	"Ne" -> (Seq("F"), "111213322112"),
	"Na" -> (Seq("Ne"), "123222112"),
	"Mg" -> (Seq("Pm", "Na"), "3113322112"),
	"Al" -> (Seq("Mg"), "1113222112"),
	"Si" -> (Seq("Al"), "1322112"),
	"P"  -> (Seq("Ho", "Si"), "311311222112"),
	"S"  -> (Seq("P"), "1113122112"),
	"Cl" -> (Seq("S"), "132112"),
	"Ar" -> (Seq("Cl"), "3112"),
	"K"  -> (Seq("Ar"), "1112"),
	"Ca" -> (Seq("K"), "12"),
	"Sc" -> (Seq("Ho", "Pa", "H", "Ca", "Co"), "3113112221133112"),
	"Ti" -> (Seq("Sc"), "11131221131112"),
	"V"  -> (Seq("Ti"), "13211312"),
	"Cr" -> (Seq("V"), "31132"),
	"Mn" -> (Seq("Cr", "Si"), "111311222112"),
	"Fe" -> (Seq("Mn"), "13122112"),
	"Co" -> (Seq("Fe"), "32112"),
	"Ni" -> (Seq("Zn", "Co"), "11133112"),
	"Cu" -> (Seq("Ni"), "131112"),
	"Zn" -> (Seq("Cu"), "312"),
	"Ga" -> (Seq("Eu", "Ca", "Ac", "H", "Ca", "Zn"), "13221133122211332"),
	"Ge" -> (Seq("Ho", "Ga"), "31131122211311122113222"),
	"As" -> (Seq("Ge", "Na"), "11131221131211322113322112"),
	"Se" -> (Seq("As"), "13211321222113222112"),
	"Br" -> (Seq("Se"), "3113112211322112"),
	"Kr" -> (Seq("Br"), "11131221222112"),
	"Rb" -> (Seq("Kr"), "1321122112"),
	"Sr" -> (Seq("Rb"), "3112112"),
	"Y"  -> (Seq("Sr", "U"), "1112133"),
	"Zr" -> (Seq("Y", "H", "Ca", "Tc"), "12322211331222113112211"),
	"Nb" -> (Seq("Er", "Zr"), "1113122113322113111221131221"),
	"Mo" -> (Seq("Nb"), "13211322211312113211"),
	"Tc" -> (Seq("Mo"), "311322113212221"),
	"Ru" -> (Seq("Eu", "Ca", "Tc"), "132211331222113112211"),
	"Rh" -> (Seq("Ho", "Ru"), "311311222113111221131221"),
	"Pd" -> (Seq("Rh"), "111312211312113211"),
	"Ag" -> (Seq("Pd"), "132113212221"),
	"Cd" -> (Seq("Ag"), "3113112211"),
	"In" -> (Seq("Cd"), "11131221"),
	"Sn" -> (Seq("In"), "13211"),
	"Sb" -> (Seq("Pm", "Sn"), "3112221"),
	"Te" -> (Seq("Eu", "Ca", "Sb"), "1322113312211"),
	"I"  -> (Seq("Ho", "Te"), "311311222113111221"),
	"Xe" -> (Seq("I"), "11131221131211"),
	"Cs" -> (Seq("Xe"), "13211321"),
	"Ba" -> (Seq("Cs"), "311311"),
	"La" -> (Seq("Ba"), "11131"),
	"Ce" -> (Seq("La", "H", "Ca", "Co"), "1321133112"),
	"Pr" -> (Seq("Ce"), "31131112"),
	"Nd" -> (Seq("Pr"), "111312"),
	"Pm" -> (Seq("Nd"), "132"),
	"Sm" -> (Seq("Pm", "Ca", "Zn"), "311332"),
	"Eu" -> (Seq("Sm"), "1113222"),
	"Gd" -> (Seq("Eu", "Ca", "Co"), "13221133112"),
	"Tb" -> (Seq("Ho", "Gd"), "3113112221131112"),
	"Dy" -> (Seq("Tb"), "111312211312"),
	"Ho" -> (Seq("Dy"), "1321132"),
	"Er" -> (Seq("Ho", "Pm"), "311311222"),
	"Tm" -> (Seq("Er", "Ca", "Co"), "11131221133112"),
	"Yb" -> (Seq("Tm"), "1321131112"),
	"Lu" -> (Seq("Yb"), "311312"),
	"Hf" -> (Seq("Lu"), "11132"),
	"Ta" -> (Seq("Hf", "Pa", "H", "Ca", "W"), "13112221133211322112211213322113"),
	"W"  -> (Seq("Ta"), "312211322212221121123222113"),
	"Re" -> (Seq("Ge", "Ca", "W"), "111312211312113221133211322112211213322113"),
	"Os" -> (Seq("Re"), "1321132122211322212221121123222113"),
	"Ir" -> (Seq("Os"), "3113112211322112211213322113"),
	"Pt" -> (Seq("Ir"), "111312212221121123222113"),
	"Au" -> (Seq("Pt"), "132112211213322113"),
	"Hg" -> (Seq("Au"), "31121123222113"),
	"Tl" -> (Seq("Hg"), "111213322113"),
	"Pb" -> (Seq("Tl"), "123222113"),
	"Bi" -> (Seq("Pm", "Pb"), "3113322113"),
	"Po" -> (Seq("Bi"), "1113222113"),
	"At" -> (Seq("Po"), "1322113"),
	"Rn" -> (Seq("Ho", "At"), "311311222113"),
	"Fr" -> (Seq("Rn"), "1113122113"),
	"Ra" -> (Seq("Fr"), "132113"),
	"Ac" -> (Seq("Ra"), "3113"),
	"Th" -> (Seq("Ac"), "1113"),
	"Pa" -> (Seq("Th"), "13"),
	"U"  -> (Seq("Pa"), "3")
)

val counts = table.map { case (_, (_, s)) =>
	('1' to '3').map( c => s.count(_ == c) )
}

type Matrix = Vector[Vector[Long]]
val elements: Matrix = Vector.tabulate(table.size, table.size)( (i, j) =>
	// I HAD A BUG HERE, an element can occur multiple times, like:
	// "Ga" -> "Eu", "Ca", "Ac", "H", "Ca", "Zn"
	table(j)._2._1.count(_ == table(i)._1)
)


val N = 1000000000000L
val M = 1L << 30

def multv(a: Matrix, b: Vector[Long]) =
	a.map( row =>
		(b, row).zipped.map(_ * _ % M).sum % M
	)

def mult(a: Matrix, b: Matrix): Matrix = {
	val bt = b.transpose
	a.map(multv(bt, _))
}
	

var output = Vector.tabulate(table.size)( i =>
	if (i == 68 || i == 46) 1L else 0L
)
var evolution = elements

var n = N - 11
while(n > 0) {
	if ((n & 1) == 1)
		output = multv(evolution, output)
	n >>= 1
	evolution = mult(evolution, evolution)
}

val result = (output, counts).zipped.map( (count, digits) =>
	digits.map(_ * count)
).transpose.map(_.sum % M)

println(result.mkString(","))
