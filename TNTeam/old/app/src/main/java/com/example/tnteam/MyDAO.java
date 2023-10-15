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

@Query("SELECT agency_name as field1, agency_address as field2 "+
        "FROM agency_table")
public List<ResultString> getQuery4();

@Query("select DISTINCT T.trip_city " +
        "from trip_table T  " +
        "where T.trip_country='Greece'")
public List<String> getQuery5();

@Query ("SELECT T.trip_city as field1 , T.trip_country as field2 "+
        "FROM trip_table T " +
        "WHERE T.trip_days='1'")
public List<ResultString> getQuery6();

@Query ("SELECT T.trip_city as field1 , T.trip_country as field2 "+
        "FROM trip_table T "+
        "WHERE T.trip_type='Ship' AND T.trip_days>'3'")
public List<ResultString> getQuery7();

@Query ("SELECT P.package_id "+
        "FROM package_table P "+
        "WHERE P.package_price>'70'")
public List<Integer> getQuery8();

@Query ("SELECT P.package_id as field1 , T.trip_city as field2 "+
        "FROM package_table P INNER JOIN TRIP_TABLE t ON p.trip_code=t.trip_id "+
        "WHERE t.trip_days>'6' AND (P.package_date='2022/12/24' OR P.package_date='2022/12/25')")
public List<ResultString> getQuery9();

@Query ("SELECT A.agency_name "+
        "FROM AGENCY_TABLE A "+
        "WHERE A.agency_address='Kentro'")
public List<String> getQuery10();


    @Query ("SELECT A.agency_name as field1 , P.package_price as field2 " +
            "FROM agency_table A INNER JOIN package_table P ON A.agency_id=P.agency_code INNER JOIN TRIP_TABLE T ON P.trip_code=T.trip_id "+
            "WHERE P.package_date='2022/08/15' and T.trip_city='Nafplio' and t.trip_days='1'")
    public List<ResultString> getQuery11();


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
public List<ResultString> getQuery14();

@Query("SELECT DISTINCT S.sname "+
        "FROM Sailor S INNER JOIN reservation R ON S.sid = R.rsid INNER JOIN BOAT B ON R.rbid = B.bid " +
        "WHERE B.bcolor=:inputcolor")
public List<String> getQuery15 (String inputcolor);
*/
}
