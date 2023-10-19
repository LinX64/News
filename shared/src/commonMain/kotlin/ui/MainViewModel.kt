package ui

import data.repository.MainRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class MainViewModel(
    private val repository: MainRepository
) : ViewModel() {

}