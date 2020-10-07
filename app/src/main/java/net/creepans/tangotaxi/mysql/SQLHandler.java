package net.creepans.tangotaxi.mysql;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQLHandler {

    public SQLHandler() {

    }

    public void createRoute(@NonNull String id,@NonNull String start,@NonNull String end) {
        MySQL.update("INSERT INTO tangotaxi_protokoll (User, Start, Ziel) VALUES(" + id + "," + start + "," + end + ")");
    }

    public void updateRoute(@NonNull String id, @Nullable String cost, @Nullable String status) {
        if (id.isEmpty()) return;
        MySQL.update("UPDATE tangotaxi_protokoll SET Kosten='" + cost + "' WHERE id='" + id + "'");
        MySQL.update("UPDATE tangotaxi_protokoll SET Status='" + status + "' WHERE id ='" + id + "'");

    }

}
