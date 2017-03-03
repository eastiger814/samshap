package com.eastiger.samshap.game;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ShapeGame implements Parcelable {
    int numColumns;
    List<Shape> shapeOrderList;
    List<Shape> shapeList;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.numColumns);
        dest.writeList(this.shapeOrderList);
        dest.writeList(this.shapeList);
    }

    protected ShapeGame(Parcel in) {
        this.numColumns = in.readInt();
        this.shapeOrderList = new ArrayList<Shape>();
        in.readList(this.shapeOrderList, Shape.class.getClassLoader());
        this.shapeList = new ArrayList<Shape>();
        in.readList(this.shapeList, Shape.class.getClassLoader());
    }

    public static final Creator<ShapeGame> CREATOR = new Creator<ShapeGame>() {
        @Override
        public ShapeGame createFromParcel(Parcel source) {
            return new ShapeGame(source);
        }

        @Override
        public ShapeGame[] newArray(int size) {
            return new ShapeGame[size];
        }
    };
}
