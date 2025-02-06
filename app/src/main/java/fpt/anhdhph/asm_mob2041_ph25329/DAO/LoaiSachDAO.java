package fpt.anhdhph.asm_mob2041_ph25329.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import fpt.anhdhph.asm_mob2041_ph25329.Database.DbHelper;
import fpt.anhdhph.asm_mob2041_ph25329.Model.LoaiSach;

public class LoaiSachDAO {
    private SQLiteDatabase db;

    public LoaiSachDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(LoaiSach obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenLoai",obj.getTenLoai());

        return db.insert("LoaiSach",null,contentValues);
    }

    public long update(LoaiSach obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenLoai",obj.getTenLoai());

        return db.update("LoaiSach",contentValues,"maLoai = ?",new String[]{String.valueOf(obj.getMaLoai())});
    }

    public int delete(String id) {
        return db.delete("LoaiSach","maLoai = ?",new String[]{String.valueOf(id)});
    }

    private List<LoaiSach> getData(String sql, String ... selectionArgs) {
        List<LoaiSach> lstLoai = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        while (cursor.moveToNext()) {
            lstLoai.add(new LoaiSach(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1)
            ));
        }
        return lstLoai;
    }

    public LoaiSach getID (String id) {
        String sql = "SELECT * FROM LoaiSach WHERE maLoai = ?";
        List<LoaiSach> lstLS = getData(sql,id);
        return lstLS.get(0);
    }

    public List<LoaiSach> getAll() {
        String sql = "SELECT * FROM LOAISACH";
        return getData(sql);
    }

    public boolean checkID(String fieldValue) {
        String Query = "Select * from LoaiSach where maLoai = " + fieldValue;
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
