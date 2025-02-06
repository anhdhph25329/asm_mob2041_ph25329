package fpt.anhdhph.asm_mob2041_ph25329.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import fpt.anhdhph.asm_mob2041_ph25329.Database.DbHelper;
import fpt.anhdhph.asm_mob2041_ph25329.Model.ThanhVien;

public class ThanhVienDAO {
    private SQLiteDatabase db;

    public ThanhVienDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(ThanhVien obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoTen", obj.getHoTen());
        contentValues.put("namSinh",obj.getNamSinh());

        return db.insert("ThanhVien",null,contentValues);
    }

    public long update(ThanhVien obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoTen", obj.getHoTen());
        contentValues.put("namSinh",obj.getNamSinh());

        return db.update("ThanhVien",contentValues,"maTV = ?",new String[]{String.valueOf(obj.getMaTV())});
    }

    public int delete(String id) {
        return db.delete("ThanhVien","maTV = ?",new String[]{String.valueOf(id)});
    }

    private List<ThanhVien> getData(String sql, String ... selectionArgs) {
        List<ThanhVien> lstTV = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,selectionArgs);
        while (cursor.moveToNext()) {
            lstTV.add(new ThanhVien(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    Integer.parseInt(cursor.getString(2))
            ));
        }
        return lstTV;
    }

    public ThanhVien getID (String id) {
        String sql = "SELECT * FROM ThanhVien WHERE maTV = ?";
        List<ThanhVien> lstTV = getData(sql,id);
        return lstTV.get(0);
    }

    public List<ThanhVien> getAll() {
        String sql = "SELECT * FROM THANHVIEN";
        return getData(sql);
    }
 }
