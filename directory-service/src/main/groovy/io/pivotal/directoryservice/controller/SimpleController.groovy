package io.pivotal.directoryservice.controller

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.sql.DataSource
import java.sql.SQLException

@RestController
class SimpleController {
    DbInfo dbInfo

    SimpleController(DBInfo dbInfo) {
        this.dbInfo = dbInfo as DbInfo
    }

    @RequestMapping("/dbinfo")
    DBInfo getInfo() {
        this.dbInfo as DBInfo
    }
}

@Component
class DBInfo {
    private String url

    DBInfo(DataSource dataSource) throws SQLException {
        this.url = dataSource.getConnection().getMetaData().getURL()
    }
}