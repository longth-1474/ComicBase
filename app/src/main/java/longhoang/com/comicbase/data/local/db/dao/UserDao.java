package longhoang.com.comicbase.data.local.db.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import longhoang.com.comicbase.data.model.db.User;

@Dao
public interface UserDao {
    @Delete
    void delete(User user);
    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
    User findByName(String name);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<User> users);
    @Query("SELECT * FROM users")
    List<User> loadAll();
    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    List<User> loadAllByIds(List<Integer> userIds);
}
