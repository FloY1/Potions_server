package ru.maveri.potions.model.jsonViev;

public interface PotionView {

    interface Properties{}

    interface Id{}

    interface ImageUrl{}


    interface PropImage extends  Properties,ImageUrl{}
    interface PropId extends  Properties,Id{}





}
