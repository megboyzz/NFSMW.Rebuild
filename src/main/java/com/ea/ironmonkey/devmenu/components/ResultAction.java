package com.ea.ironmonkey.devmenu.components;

import android.content.Intent;

/**
 * Функциональный интерфейс для предоставления действия в резултате закрытия Активности
 */
public interface ResultAction {
    /**
     * Действие по закритии Активности<br>
     * Важно! Не работает при входящем интете с экшоном {@link Intent#ACTION_VIEW}
     * т.к. такой интент всегда вернет null в {@link android.app.Activity#onActivityResult(int, int, Intent)}
     * @param data интент который активность передаст с данными которыве она обработала
     */
    void action(Intent data);
}
