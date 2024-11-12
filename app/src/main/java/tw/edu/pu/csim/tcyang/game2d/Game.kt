package tw.edu.pu.csim.tcyang.game2d

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import kotlinx.coroutines.flow.MutableStateFlow

class Game(val scope: CoroutineScope, screenW: Int, screenH: Int) {
    var counter = 0
    val state = MutableStateFlow(0)
    val background = Background(screenW)

    fun Play(){
        scope.launch {
            counter = 0
            while (counter<5000) {
                delay(40)
                background.Roll()
                counter++
                state.emit(counter)
            }
        }
    }
}