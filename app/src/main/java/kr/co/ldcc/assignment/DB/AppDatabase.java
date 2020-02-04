package kr.co.ldcc.assignment.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import kr.co.ldcc.assignment.Dao.BookmarkDao;
import kr.co.ldcc.assignment.Dao.ReplyDao;
import kr.co.ldcc.assignment.Vo.BookmarkVo;
import kr.co.ldcc.assignment.Vo.ReplyVo;

@Database(entities = {ReplyVo.class, BookmarkVo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    public abstract ReplyDao replyDao();
    public abstract BookmarkDao bookmarkDao();
    private static AppDatabase INSTANCE;

    private static final Object sLock = new Object();

    public static AppDatabase getInstance(Context context){
        synchronized (sLock){
            if(INSTANCE== null){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "ecommerce.db")
                .build();
            }
            return INSTANCE;
        }
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
