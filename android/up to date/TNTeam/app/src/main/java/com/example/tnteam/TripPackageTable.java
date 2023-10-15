//    PETRIAMOS
package com.example.tnteam;
import androidx.annotation.NonNull;import androidx.room.ColumnInfo;
import androidx.room.Entity;import androidx.room.ForeignKey;import androidx.room.PrimaryKey;

@Entity(tableName = "package_table",

        //primaryKeys = {"package_id"},
        //primaryKeys = {"package_id",agency_code},
        //primaryKeys = {"package_id","agency_code","trip_code"},
        //primaryKeys = {"agency_code","trip_code","package_id"},
        foreignKeys = {
                @ForeignKey(entity = AgencyTable.class,
                        parentColumns = "agency_id",
                        childColumns = "agency_code",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE),
                @ForeignKey(entity = TripTable.class,
                        parentColumns = "trip_id",
                        childColumns = "trip_code",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)  } )
public class TripPackageTable {

    @PrimaryKey
    @ColumnInfo(name = "package_id")
    private int id;

    @ColumnInfo(name = "agency_code")
    private int agencyCode;

    @ColumnInfo(name = "trip_code")
    private int tripCode;

    @ColumnInfo(name = "package_date")
    private String departure;

    @ColumnInfo(name = "package_price")
    private double price;

    public int getId() { return id; }
    public void setId(int id) { this.id = id;}

    public int getAgencyCode() {return agencyCode;}
    public void setAgencyCode(int agencyCode) {this.agencyCode = agencyCode;        }

    public int getTripCode() { return tripCode;}
    public void setTripCode(int tripCode) { this.tripCode = tripCode; }

    public String getDeparture() { return departure;}
    public void setDeparture(String departure){this.departure = departure;        }

    public double getPrice() { return price;}
    public void setPrice(double price) { this.price = price;}
}
