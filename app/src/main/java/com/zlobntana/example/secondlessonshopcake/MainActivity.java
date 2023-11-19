package com.zlobntana.example.secondlessonshopcake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // создадим поля
    private float biscuit = 10;//бисквитные коржи
    private int biscuitDiscount = 26;//скидка на бисквитные коржи
    private float cream = 14;//сливки
    private int creamDiscount = 5;//скидка на сливки
    private float fruit = 3;// фрукты
    private int fruitDiscount = 12;//скидка на фрукты
    private float nuts = 5;// орехи
    private int nutsDiscount = 55;//скидка на орехи
    private float berries = 7;// ягоды
    private float account = 45;//баланс на счету
    //создание дополнительныхполей для вывода на экран полученных значений
    private TextView possibilityOut;//поле возможности покупки
    private TextView balanceOut;//поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активности представления activity_main

        possibilityOut = findViewById(R.id.possiblityOut); //вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut);// вывод информации и возможном остатке от покупки
        //заполнение экрана
        if (possibility()) {//если имеется возможность купить ингредиенты
            possibilityOut.setText("Имеется достаточно средств для покупки ингредиентов");
            balanceOut.setText("Остаток от покупки" + balance() + "монет");
        } else {// иначе
            possibilityOut.setText("Недостаточно средств для покупки ингредиентов");
            balanceOut.setText("-");
        }
    }

    // метод подсчёта стоимости ингредиентов для приготовления торта
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (biscuit * (100 - biscuitDiscount) + cream * (100 - creamDiscount) + fruit * (100 - fruitDiscount)
                + nuts * (100 - nutsDiscount)) / 100 + berries;
        return count; //возврат подсчитанного значения
    }

    //метод определения возможностей бюджета покупки ингредиентов
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость ингредиентов меньше имеющихся средств
            return true; //то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    //метод определения возможной сдачи
    private float balance() {
        if (possibility()) {//если имеется возможность купить ингредиенты
            return account - calculation();//то возвращается остаток от покупки
        } else {// иначе
            return -1;//возвращается маркер недостатка денежных средств
        }
    }
}
