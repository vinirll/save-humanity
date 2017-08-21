import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

class test: Spek({
    describe("Z Array") {
        it("should be equal to string provided") {
            val p = "aabxaayaab"
            val arr = calculateZArr(p)
            assertEquals(true, arr.size == p.length)
        }

        it("should be equal zero when all elements are different") {
            val p = "abcdefghijk"
            val arr = calculateZArr(p)
            assertEquals(true,arr contentEquals Array(p.length,{0}))
        }

        it("should be equal decrease by one factor when all elements are equal") {
            val p = "aaaaa"
            val arr = calculateZArr(p)
            assertEquals(true,arr contentEquals arrayOf(0,4,3,2,1))
        }

        it("should matchWithOneTolerance all known cases") {
            assertEquals(true,calculateZArr("aabxaayaab") contentEquals arrayOf(0,1,0,0,2,1,0,3,1,0))
            assertEquals(true,calculateZArr("abaxabab") contentEquals arrayOf(0,0,1,0,3,0,2,0))
        }
    }

    describe("makeInputZFormat") {
        it("should be different when reversed") {
            val p = "ab"
            val t = "abbcc"
            assertEquals(false, makeInputZFormat(t,p,false) == makeInputZFormat(t,p,true))
        }

        it("should be reversed") {
            val p = "ab"
            val t = "abbccde"
            assertEquals(true,"ba\$edccbba"  == makeInputZFormat(t,p,true))
        }
    }

    describe("Pattern Finder") {
        it("should match all known cases") {
            var r = matchWithOneTolerance("aaaaaaaaaab","aaaab")
            assertEquals(true,setOf(0,1,2,3,4,5,6).equals(r))

            r = matchWithOneTolerance("abcdeff","ff")
            assertEquals(true,setOf(4,5).equals(r))

            r = matchWithOneTolerance("abcdaaaaaaaaaabeff","xx")
            assertEquals(true,r.isEmpty())
        }
    }
})