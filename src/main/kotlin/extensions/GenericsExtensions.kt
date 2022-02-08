package extensions

inline fun <reified T> T.doAction(action:() -> T){
    action();
}