package com.javarush.task.task14.task1408;

import com.javarush.task.task14.task1408.Hen;

public class RussianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" Моя страна - "+Country.RUSSIA+"."+" Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
