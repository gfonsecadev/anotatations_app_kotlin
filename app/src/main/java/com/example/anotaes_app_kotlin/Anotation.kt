package com.example.anotaes_app_kotlin

import android.content.Context
import android.content.SharedPreferences
import android.text.Editable
import android.view.View
import com.google.android.material.snackbar.Snackbar


class Anotation(private val context: Context) {
    //instância de SharedPreferences(passando nome do arquivo e o modo de operação)
    private val preferences: SharedPreferences = context.getSharedPreferences("PREFERENCE", 0)
    //instância de edição do objeto acima
    private val editor: SharedPreferences.Editor = preferences.edit()

    //variavel para armazenar os dados
    private var dataAnotation: String? = ""

    //metodo para salvar em SharedPreferences
    fun save(text: String, view: View?) {
        if (text != "") {
            //o metodo puString recebe o nome da chave e seu valor
            editor.putString("Anotation", text)
            //salva
            editor.commit()
            Snackbar.make(view!!, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(view!!, "Por favor escreva algo!", Snackbar.LENGTH_LONG).show()
        }
    }

    //metodo para recuperar dados de  SharedPreference
    fun retrieveData() : Editable? {
        //recuperamos do arquivo PREFERENCE salvo mais acima pela instância de getSharedPreferences o valor da chave Anotation
        val anotation = preferences.getString("Anotation", "")
        //se a chave contiver valor
        if (anotation != "") {
            dataAnotation = anotation
        }
        //EditText recebe um Editable em kotlin precisamos da chamada do metódo abaixo
        return  Editable.Factory.getInstance().newEditable(dataAnotation)
    }

    //alerta de uma snackbar de quando o usuário entra na aplicação
    fun alert(view: View?) {
        if (preferences.contains("Anotation")) {
            Snackbar.make(view!!, "Você possui anotações salvas", Snackbar.LENGTH_LONG).show()
        }
    }
}

