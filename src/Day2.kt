package com.morkalork.adventOfCode

class Day2 {
    val input = """515	912	619	2043	96	93	2242	1385	2110	860	2255	621	1480	118	1230	99
        161	6142	142	1742	237	6969	211	4314	5410	4413	3216	6330	261	3929	5552	109
        1956	4470	3577	619	105	3996	128	1666	720	4052	108	132	2652	306	1892	1869
        2163	99	2257	895	112	1771	1366	1631	2064	2146	103	865	123	1907	2362	876
        1955	3260	1539	764	185	5493	5365	5483	4973	175	207	1538	4824	205	1784	2503
        181	3328	2274	3798	1289	2772	4037	851	1722	3792	175	603	725	158	2937	174
        405	247	2083	956	725	258	2044	206	2054	561	2223	2003	2500	355	306	2248
        837	937	225	1115	446	451	160	1219	56	61	62	922	58	1228	1217	1302
        1371	1062	2267	111	135	2113	1503	2130	1995	2191	129	2494	2220	739	138	1907
        3892	148	2944	371	135	1525	3201	3506	3930	3207	115	3700	2791	597	3314	132
        259	162	186	281	210	180	184	93	135	208	88	178	96	25	103	161
        1080	247	1036	936	108	971	908	1035	123	974	103	1064	129	1189	1089	938
        148	1874	122	702	922	2271	123	111	454	1872	2142	2378	126	813	1865	1506
        842	267	230	1665	2274	236	262	1714	3281	4804	4404	3833	661	4248	3893	1105
        1112	1260	809	72	1104	156	104	1253	793	462	608	84	99	1174	449	929
        707	668	1778	1687	2073	1892	62	1139	908	78	1885	800	945	712	57	65"""

    fun getRows(str: String): List<String> {
        return str.split("[\\n]".toRegex())
    }

    fun getCols(row: String): List<Int> {
        return row.trim().split("[\\t\\s]".toRegex()).map { col -> col.toInt() }
    }

    fun part1() {
        var sum = 0
        val rows = getRows(input)
        for (row in rows) {
            val cols = getCols(row)
            val lowestValue = cols.min() ?: throw IllegalArgumentException("lowest")
            val highestValue = cols.max() ?: throw IllegalArgumentException("highest")
            val diff = highestValue.minus(lowestValue)
            sum += diff
            println("Adding $diff to sum ($sum)")
        }

        println("Total sum is $sum")
    }


    fun part2() {
        var sum = 0
        val rows = getRows(input)
        for (row in rows) {
            val cols = getCols(row)
            for (i in cols.indices) {
                val col = cols[i]
                for (j in 0 until cols.size) {
                    if (i !== j) {
                        val otherCol = cols[j]
                        println("$col & $otherCol === ${col % otherCol}")
                        if (col % otherCol === 0) {
                            val dividends = intArrayOf(col, otherCol)
                            val min = dividends.min() ?: throw IllegalArgumentException("lowest")
                            val max = dividends.max() ?: throw IllegalArgumentException("highest")
                            val diff = max / min
                            println("$max / $min = $diff, Imma gonna add this")
                            sum += diff
                        }
                    }
                }
            }
        }

        println("Total sum is $sum")
    }

    fun run() {
        part1()
        part2()
    }
}