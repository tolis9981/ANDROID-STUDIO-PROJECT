//    PETRIANOS
package com.example.tnteam;
import androidx.room.Dao;
import androidx.room.Delete; import androidx.room.Insert;
import androidx.room.Query; import androidx.room.Update;
import java.util.List;

@Dao
public interface MyDAO {
    @Insert
    public void insertAgency(AgencyTable agency);
    @Insert
    public void insertTrip(TripTable trip);
    @Insert
    public void insertTripPackage(TripPackageTable tripPackage);

    @Delete
    public void deleteAgency(AgencyTable agency);
    @Delete
    public void deleteTrip(TripTable trip);
    @Delete
    public void deleteTripPackage(TripPackageTable tripPackage);

    @Update
    public void updateAgency(AgencyTable agency);
    @Update
    public void updateTrip(TripTable trip);
    @Update
    public void updateTripPackage(TripPackageTable tripPackage);


/*    PROGIOS    */

@Query("select * from agency_table")
public List<AgencyTable> getAgencyTable();
@Query("select * from trip_table")
public List<TripTable> getTripTable();
@Query("select * from package_table")
public List<TripPackageTable> getTripPackageTable();



@Query("SELECT agency_id as field1, agency_name as field2 "+
        "FROM agency_table")
public List<ResultStringInt> getQuery4();

@Query("select * " +
        "from agency_table " +
        "where agency_name='Diakopes' & agency_address='Thessaloniki'")
public List<AgencyTable> getQuery5();

@Query ("SELECT DISTINCT A.agency_name "+
        "FROM agency_table A INNER JOIN package_table P ON A.agency_id = P.agency_code " +
        "WHERE P.package_date='2022-05-26'")
public List<String> getQuery6();


/*

@Query ("SELECT DISTINCT R.rsid " +
        "FROM reservation R INNER JOIN boat B ON R.rbid = B.bid "+
        "WHERE B.bcolor='red'")
public List<Integer> getQuery7();

@Query ("SELECT DISTINCT S. sname " +
        "FROM Sailor S INNER JOIN reservation R ON S.sid = R.rsid INNER JOIN BOAT B ON R.rbid = B.bid "+
        "WHERE B.bcolor='red'")
public List<String> getQuery8();


@Query("SELECT S.sage "+
        "FROM Sailor S " +
        "WHERE S.sname LIKE 'A_%y' ")
public List<Integer> getQuery9();

@Query ("SELECT DISTINCT S.sname " +
        "FROM Sailor S INNER JOIN reservation R ON S.sid = R.rsid INNER JOIN BOAT B ON R.rbid = B.bid " +
        "WHERE B.bcolor='red' "+
        "INTERSECT " +
        "SELECT DISTINCT S.sname "+
        "FROM Sailor S INNER JOIN reservation R ON S.sid = R. rsid INNER JOIN BOAT B ON R.rbid = B.bid " +
        "WHERE B.bcolor='green' ")
public List<String> getQuery10();

@Query("SELECT DISTINCT S.sid " +
        "FROM Sailor S INNER JOIN reservation R ON S.sid = R.rsid INNER JOIN BOAT B ON R.rbid = B.bid " +
        "WHERE B.bcolor='red' "+
        "EXCEPT " +
        "SELECT DISTINCT S.sid " +
        "FROM Sailor S INNER JOIN reservation R ON S.sid=R.rsid INNER JOIN BOAT B ON R.rbid = B.bid " + "WHERE B.bcolor= 'green'")
public List<Integer> getQuery11();

@Query ("SELECT DISTINCT S.sname " +
        "FROM Sailor S " +
        "WHERE S.sid IN (SELECT R.rsid " +
        "FROM reservation R " +
        "WHERE R.rbid IN (SELECT B.bid " +
        "FROM BOAT B " +
        "WHERE B.bcolor = 'red'))")
public List<String> getQuery12();

@Query("SELECT S.sname "+
        "FROM Sailor S "+
        "WHERE EXISTS (SELECT *"+
        "FROM reservation R INNER JOIN Boat B ON R.rbid = B.bid " +
        "WHERE S.sid = R.rsid AND B.bcolor= 'red')")
public List<String> getQuery13();

@Query("SELECT sname as field1, Max(sage) as field2 " +
        "FROM sailor " +
        "GROUP BY sname")
public List<ResultStringInt> getQuery14();

@Query("SELECT DISTINCT S.sname "+
        "FROM Sailor S INNER JOIN reservation R ON S.sid = R.rsid INNER JOIN BOAT B ON R.rbid = B.bid " +
        "WHERE B.bcolor=:inputcolor")
public List<String> getQuery15 (String inputcolor);
*/
}
