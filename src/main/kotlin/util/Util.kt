fun readIntFromConsole(): Int {
    return try{
        readLine()?.toInt() ?: -1
    }catch (e: NumberFormatException){
        -1
    }
}


