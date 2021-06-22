package study.sort

/*
    삽입정렬
    정렬된 배열에 끼워넣는 방식
    Key Index를 배열의 앞에서부터 설정한다.
    Key Index에 해당하는 원소와, 그 Index 앞의 배열을 비교하여 적절한 위치에 꽃아주는 방식.
    이 때, Index 앞의 원소들은 이미 정렬이 되어있다고 생각하면 됨.
 */
class InsertionSort(val arr: IntArray) {

    fun sortAsc(): IntArray {
        for(keyIndex in 1 until arr.size) {
            val key = arr[keyIndex]
            for(next in (keyIndex - 1) downTo 0) {
                if(key < arr[next]) {
                    arr[next + 1] = arr[next]
                    arr[next] = key
                } else {
                    break
                }
            }
        }
        return arr
    }
}