package algorithms.searching.binary_search

/**
 * Binary search only works with only sorted arrays
 */
/*
class BinarySearch {
    fun binarySearch(arr: IntArray, key: Int): String {
        var first = 0
        var last = arr.size - 1
        var middle = (first + last) / 2
        while (first <= last) {
            when {
                arr[middle] < key -> {
                    first = middle + 1
                }
                arr[middle] == key -> {
                    return "Element Found At Index $middle"
                }
                arr[middle] > key -> {
                    last = middle - 1
                }
            }
            middle = (first + last) / 2
        }
        return "Element Not Found"
    }
}

fun main() {
    val binarySearch = BinarySearch()
    val array = intArrayOf(10, 25, 32, 45, 55, 68)
    val result = binarySearch.binarySearch(array, 55)
    println(result)
    val result2 = binarySearch.binarySearch(array, 100)
    println(result2)
}*/
fun main(){
    println("Enter the size of the array")
    val n = readLine()!!.trim().toInt()
    val arr = readLine()!!.trim().split(',').map{it.trim().toInt()}.toTypedArray()

    val key = 50
    binarySearch(arr,n,key)

}
fun binarySearch(arr:Array<Int>,n:Int,key:Int){

    println(arr.joinToString())
    var start = 0
    var end = arr.size - 1

    while(start <= end){
        val mid = (start + end)/2

        when{
            key < arr[mid] -> {
                end = mid - 1
            }
            key > arr[mid] ->{
                start = mid + 1
            }
            key == arr[mid] -> {
                println(mid)
                return

            }
            }

        }
    val arr = listOf("0123456789","abc")
    val s = "123"
    println(arr.count{
            pat ->
        pat.none{
        s.contains(it)}})
    println(-1)
    }

