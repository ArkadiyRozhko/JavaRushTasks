package com.javarush.task.task14.task1408;

import com.javarush.task.task14.task1408.Hen;

public class UkrainianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 20;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" Моя страна - "+Country.UKRAINE+"."+" Я несу "+this.getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
