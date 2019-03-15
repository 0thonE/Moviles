package com.tareas.tarea_03.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable {
    private String name;
    private String store;//
    private String phone;//
    private String title;//
    private String location;//
    private String description;//
    private int image;//
    private int code;//

    public ItemProduct(){
    }

    public ItemProduct(Parcel in){
        image = in.readInt();
        code = in.readInt();
        name = in.readString();
        title = in.readString();
        store = in.readString();
        location = in.readString();
        phone = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeInt(code);
        dest.writeString(name);
        dest.writeString(title);
        dest.writeString(store);
        dest.writeString(location);
        dest.writeString(phone);
        dest.writeString(description);
    }

    public static final Parcelable.Creator<ItemProduct> CREATOR = new
            Parcelable.Creator<ItemProduct>() {

                @Override
                public ItemProduct createFromParcel(Parcel source) {
                    return new ItemProduct(source);
                }

                @Override
                public ItemProduct [] newArray(int size) {
                    return new ItemProduct [size];
                }
            };

    @Override
    public String toString() {
        return "ItemProduct{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
