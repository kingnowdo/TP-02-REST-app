package com.gui_rei.tempopreparar;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private static Context context;
    private static final Prefs ourInstance = new Prefs();

    public static int tempMostrarAviso = 1; //Se eh pra mostrar o aviso de rotina(seta pra 0 quando mostrar) //Esse é temporário, n eh pra salvar

    private int city;
    private static final String keyCity = "cidade";
    private static final String PREFID = "apppref";

    private int temRotinaAmanha = 0; //Para test por enquanto, depois ser uma classe q armazena data e mais

    public static Prefs getInstance() {
        return ourInstance;
    }
    private Prefs() {}
    public void setContextAndLoad(Context context) {
        Prefs.context = context;
        SharedPreferences pref = context.getSharedPreferences(PREFID, 0);
        this.city = pref.getInt(keyCity, 6879);
    }

    public int getCity() {
        return city;
    }
    public void setCity(int city) {
        this.city = city;

        SharedPreferences pref = context.getSharedPreferences(PREFID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(keyCity, city);
        editor.commit();
    }

    public int getTemRotinaAmanha() {
        return temRotinaAmanha;
    }
    public void setTemRotinaAmanha(int temRotinaAmanha) {
        this.temRotinaAmanha = temRotinaAmanha;
    }
}
