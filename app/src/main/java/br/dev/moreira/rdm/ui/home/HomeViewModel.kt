package br.dev.moreira.rdm.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.dev.moreira.rdm.DatabaseService
import br.dev.moreira.rdm.Event
import br.dev.moreira.rdm.Medidas
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    var chest = MutableLiveData<String>()
    var left_biceps = MutableLiveData<String>()
    var right_biceps = MutableLiveData<String>()
    var left_forearm = MutableLiveData<String>()
    var right_forearm = MutableLiveData<String>()
    var waist = MutableLiveData<String>()
    var hips = MutableLiveData<String>()
    var left_thigh = MutableLiveData<String>()
    var right_thigh = MutableLiveData<String>()
    var left_calf = MutableLiveData<String>()
    var right_calf = MutableLiveData<String>()
    var weight = MutableLiveData<String>()

    private val _notifySave = MutableLiveData<Event<Boolean>>()
    val notifySave: LiveData<Event<Boolean>>
        get() = _notifySave

    @OptIn(DelicateCoroutinesApi::class)
    fun save() {

        GlobalScope.launch {
            DatabaseService.getDB().medidasDao().insert(
                Medidas(
                    System.currentTimeMillis(),
                    chest = chest.value.toString().toFloat(),
                    left_biceps = left_biceps.value.toString().toFloat(),
                    right_biceps = right_biceps.value.toString().toFloat(),
                    left_forearm = left_forearm.value.toString().toFloat(),
                    right_forearm = right_forearm.value.toString().toFloat(),
                    waist = waist.value.toString().toFloat(),
                    hips = hips.value.toString().toFloat(),
                    left_thigh = left_thigh.value.toString().toFloat(),
                    right_thigh = right_thigh.value.toString().toFloat(),
                    left_calf = left_calf.value.toString().toFloat(),
                    right_calf = right_calf.value.toString().toFloat(),
                    weight = weight.value.toString().toFloat()
                )
            )

            withContext(Dispatchers.Main) {
                _notifySave.value = Event(true);
                clear()
            }

        }
    }

    fun clear() {
        chest.value = ""
        left_biceps.value = ""
        right_biceps.value = ""
        left_forearm.value = ""
        right_forearm.value = ""
        waist.value = ""
        hips.value = ""
        left_thigh.value = ""
        right_thigh.value = ""
        left_calf.value = ""
        right_calf.value = ""
        weight.value = ""
    }
}