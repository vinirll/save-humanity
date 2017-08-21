fun matchWithOneTolerance(t:String, p:String):Set<Int> {
    val zArr: Array<Int> = calculateZArr(makeInputZFormat(t,p,false))
    val zArrReverse: Array<Int> = calculateZArr(makeInputZFormat(t,p,true))

    val r = LinkedHashSet<Int>()
    for( i in p.length+1..zArr.size-p.length) {
        val k = i - p.length - 1
        if ( zArr[i]==p.length || zArr[i]==p.length-1 ) {
            if (k >=0 && k <t.length) {
                r.add(k)
            }
        } else {
            val zi = i  - 1 + p.length
            if (zArrReverse[zArr.size - zi + p.length] >= p.length - zArr[i] - 1) {
                if ( k >= 0 && k < t.length ) {
                    r.add(k)
                }
            }
        }
    }
    return r
}

fun makeInputZFormat(t:String, p:String,reversed:Boolean):String = if (!reversed)
                                                                        "${p}$${t}"
                                                                    else
                                                                        "${p.reversed()}$${t.reversed()}"

/* This is the implementation of the well known Z Algorithm */
fun calculateZArr(cInput:String): Array<Int> {
    val zArr: Array<Int> = Array(cInput.length,{0})
    var l = 0
    var r = 0

    for (i in 1..cInput.length-1) {
        if ( i > r ) {
            l = i
            r = i
            while (r < cInput.length && cInput[r] == cInput[r-l]) r++
            zArr[i] = r - l
            r--
        } else {
            val k = i - l
            if (zArr[k] < r + 1 - i) {
                zArr[i] = zArr[k]
            } else {
                l = i
                while (r < cInput.length && cInput[r] == cInput[r-l]) r++
                zArr[i] = r - l
                r--
            }
        }
    }
    return zArr
}

fun main(args: Array<String>) {

    val nOfSamples:Int = readLine()!!.toInt()
    for (i in 0..nOfSamples-1) {
        val (dna,virus) = readLine()!!.split(' ')
        val result = matchWithOneTolerance(dna,virus)
        if (result.size != 0) {
            result.forEach { print("${it} ") }
            println()
        } else {
            println("No Match!")
        }
    }

}