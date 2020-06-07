package dictionary

class Node(var left: Node? = null, var right: Node? = null,public var keyword: String? = null,public var meaning: String? = null) {



    fun Node() {
        left = null
         right = null
        keyword = "\u0000"
         meaning = "\u0000"
    }

    fun Node(x: String?, y: String) {
        left = null
         right = null
        keyword = x
         meaning = y
    }
}