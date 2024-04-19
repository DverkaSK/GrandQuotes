package ru.dverkask.grandquotes.database;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import ru.dverkask.grandquotes.GrandQuotes;
import ru.dverkask.grandquotes.Quote;
import ru.dverkask.grandquotes.utils.ColorUtils;
import ru.dverkask.grandquotes.utils.mapper.QuoteMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.List;

public class SQLiteDatabaseService implements DatabaseService {
    private final DSLContext dsl;

    @SneakyThrows public SQLiteDatabaseService(String path) {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + GrandQuotes.getInstance().getDataFolder().getPath() + "\\" + path);
        this.dsl = DSL.using(connection, SQLDialect.SQLITE);

        initializeDatabase();
    }

    private void initializeDatabase() {
        this.dsl.createTableIfNotExists("quotes")
                .column("id", SQLDataType.INTEGER.length(255).identity(true))
                .column("target", SQLDataType.VARCHAR.length(255))
                .column("owner", SQLDataType.VARCHAR.length(255))
                .column("text", SQLDataType.VARCHAR.length(255))
                .column("title", SQLDataType.VARCHAR.length(255))
                .column("attribution", SQLDataType.VARCHAR.length(255))
                .column("background_color_hex", SQLDataType.VARCHAR.length(255))
                .column("stroke_color_hex", SQLDataType.VARCHAR.length(255))
                .execute();
    }

    @Override public void saveQuote(Quote quote) {
        this.dsl.insertInto(DSL.table("quotes"),
                DSL.field("target"), DSL.field("owner"), DSL.field("text"), DSL.field("attribution"),
                DSL.field("title"), DSL.field("background_color_hex"), DSL.field("stroke_color_hex")
        ).values(quote.getPlayer().getName(), quote.getOwner().getName(), quote.getText(),
                quote.getTitle(), quote.getAttribution(),
                ColorUtils.toHexString(quote.getBackground()), ColorUtils.toHexString(quote.getStrokeColor())
        ).execute();
    }

    @Override public Quote getQuoteById(int id) {
        Record record = this.dsl.selectFrom(DSL.table("quotes"))
                .where(DSL.field("id").eq(id))
                .fetchOne();
        if (record != null) {
            return QuoteMapper.mapRecordToQuote(record);
        }
        return null;
    }

    @Override public List<Quote> getAllQuotes() {
        Record result = (Record) this.dsl.selectFrom(DSL.table("quotes")).fetch();

        return Collections.singletonList(result.map(QuoteMapper::mapRecordToQuote
        ));
    }
}
