package config;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Properties;
import javax.cache.configuration.Factory;
import javax.sql.DataSource;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.QueryEntity;
import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.cache.store.jdbc.JdbcType;
import org.apache.ignite.cache.store.jdbc.JdbcTypeField;
import org.apache.ignite.cache.store.jdbc.dialect.BasicJdbcDialect;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.postgresql.ds.PGPoolingDataSource;

public class ServerConfigurationFactory {
    /** Secret properties loading. **/
    private static final Properties props = new Properties();

    static {
        try (InputStream in = IgniteConfiguration.class.getClassLoader().getResourceAsStream("secret.properties")) {
            props.load(in);
        }
        catch (Exception ignored) {
            // No-op.
        }
    }

    /** Helper class for datasource creation. **/
    public static class DataSources {
        public static final PGPoolingDataSource INSTANCE_dsPostgreSQL_World = createdsPostgreSQL_World();

        private static PGPoolingDataSource createdsPostgreSQL_World() {
            PGPoolingDataSource dsPostgreSQL_World = new PGPoolingDataSource();

            dsPostgreSQL_World.setUrl(props.getProperty("dsPostgreSQL_World.jdbc.url"));
            dsPostgreSQL_World.setUser(props.getProperty("dsPostgreSQL_World.jdbc.username"));
            dsPostgreSQL_World.setPassword(props.getProperty("dsPostgreSQL_World.jdbc.password"));

            return dsPostgreSQL_World;
        }
    }

    /**
     * Configure grid.
     * 
     * @return Ignite configuration.
     * @throws Exception If failed to construct Ignite configuration instance.
     **/
    public static IgniteConfiguration createConfiguration() throws Exception {
        IgniteConfiguration cfg = new IgniteConfiguration();

        cfg.setIgniteInstanceName("ImportedCluster");

        TcpDiscoverySpi discovery = new TcpDiscoverySpi();

        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();

        ipFinder.setAddresses(Arrays.asList("127.0.0.1:47500..47510"));

        discovery.setIpFinder(ipFinder);

        cfg.setDiscoverySpi(discovery);

        cfg.setCacheConfiguration(
            cacheCityCache(),
            cacheCountryCache(),
            cacheCountrylanguageCache()
        );

        return cfg;
    }

    /**
     * Create configuration for cache "CityCache".
     * 
     * @return Configured cache.
     * @throws Exception if failed to create cache configuration.
     **/
    public static CacheConfiguration cacheCityCache() throws Exception {
        CacheConfiguration ccfg = new CacheConfiguration();

        ccfg.setName("CityCache");
        ccfg.setCacheMode(CacheMode.PARTITIONED);
        ccfg.setAtomicityMode(CacheAtomicityMode.ATOMIC);

        CacheJdbcPojoStoreFactory cacheStoreFactory = new CacheJdbcPojoStoreFactory();

        cacheStoreFactory.setDataSourceFactory(new Factory<DataSource>() {
            /** {@inheritDoc} **/
            @Override public DataSource create() {
                return DataSources.INSTANCE_dsPostgreSQL_World;
            };
        });

        cacheStoreFactory.setDialect(new BasicJdbcDialect());

        cacheStoreFactory.setTypes(jdbcTypeCity(ccfg.getName()));

        ccfg.setCacheStoreFactory(cacheStoreFactory);

        ccfg.setReadThrough(true);
        ccfg.setWriteThrough(true);

        ArrayList<QueryEntity> qryEntities = new ArrayList<>();

        QueryEntity qryEntity = new QueryEntity();

        qryEntity.setKeyType("java.lang.Integer");
        qryEntity.setValueType("cl.falabella.pnigam.model.City");
        qryEntity.setKeyFieldName("id");

        HashSet<String> keyFields = new HashSet<>();

        keyFields.add("id");

        qryEntity.setKeyFields(keyFields);

        LinkedHashMap<String, String> fields = new LinkedHashMap<>();

        fields.put("name", "java.lang.String");
        fields.put("countrycode", "java.lang.String");
        fields.put("district", "java.lang.String");
        fields.put("population", "java.lang.Integer");
        fields.put("id", "java.lang.Integer");

        qryEntity.setFields(fields);
        qryEntities.add(qryEntity);

        ccfg.setQueryEntities(qryEntities);

        return ccfg;
    }

    /**
     * Create JDBC type for "jdbcTypeCity".
     * 
     * @param cacheName Cache name.
     * @return Configured JDBC type.
     **/
    private static JdbcType jdbcTypeCity(String cacheName) {
        JdbcType type = new JdbcType();

        type.setCacheName(cacheName);
        type.setKeyType(Integer.class);
        type.setValueType("cl.falabella.pnigam.model.City");
        type.setDatabaseSchema("public");
        type.setDatabaseTable("city");

        type.setKeyFields(new JdbcTypeField(Types.INTEGER, "id", int.class, "id"));

        type.setValueFields(
            new JdbcTypeField(Types.VARCHAR, "name", String.class, "name"),
            new JdbcTypeField(Types.CHAR, "countrycode", String.class, "countrycode"),
            new JdbcTypeField(Types.VARCHAR, "district", String.class, "district"),
            new JdbcTypeField(Types.INTEGER, "population", int.class, "population")
        );

        return type;
    }

    /**
     * Create configuration for cache "CountryCache".
     * 
     * @return Configured cache.
     * @throws Exception if failed to create cache configuration.
     **/
    public static CacheConfiguration cacheCountryCache() throws Exception {
        CacheConfiguration ccfg = new CacheConfiguration();

        ccfg.setName("CountryCache");
        ccfg.setCacheMode(CacheMode.PARTITIONED);
        ccfg.setAtomicityMode(CacheAtomicityMode.ATOMIC);

        CacheJdbcPojoStoreFactory cacheStoreFactory = new CacheJdbcPojoStoreFactory();

        cacheStoreFactory.setDataSourceFactory(new Factory<DataSource>() {
            /** {@inheritDoc} **/
            @Override public DataSource create() {
                return DataSources.INSTANCE_dsPostgreSQL_World;
            };
        });

        cacheStoreFactory.setDialect(new BasicJdbcDialect());

        cacheStoreFactory.setTypes(jdbcTypeCountry(ccfg.getName()));

        ccfg.setCacheStoreFactory(cacheStoreFactory);

        ccfg.setReadThrough(true);
        ccfg.setWriteThrough(true);

        ArrayList<QueryEntity> qryEntities = new ArrayList<>();

        QueryEntity qryEntity = new QueryEntity();

        qryEntity.setKeyType("java.lang.String");
        qryEntity.setValueType("cl.falabella.pnigam.model.Country");
        qryEntity.setKeyFieldName("code");

        HashSet<String> keyFields = new HashSet<>();

        keyFields.add("code");

        qryEntity.setKeyFields(keyFields);

        LinkedHashMap<String, String> fields = new LinkedHashMap<>();

        fields.put("name", "java.lang.String");
        fields.put("continent", "java.lang.String");
        fields.put("region", "java.lang.String");
        fields.put("surfacearea", "java.lang.Double");
        fields.put("indepyear", "java.lang.Short");
        fields.put("population", "java.lang.Integer");
        fields.put("lifeexpectancy", "java.lang.Double");
        fields.put("gnp", "java.math.BigDecimal");
        fields.put("gnpold", "java.math.BigDecimal");
        fields.put("localname", "java.lang.String");
        fields.put("governmentform", "java.lang.String");
        fields.put("headofstate", "java.lang.String");
        fields.put("capital", "java.lang.Integer");
        fields.put("code2", "java.lang.String");
        fields.put("code", "java.lang.String");

        qryEntity.setFields(fields);
        qryEntities.add(qryEntity);

        ccfg.setQueryEntities(qryEntities);

        return ccfg;
    }

    /**
     * Create JDBC type for "jdbcTypeCountry".
     * 
     * @param cacheName Cache name.
     * @return Configured JDBC type.
     **/
    private static JdbcType jdbcTypeCountry(String cacheName) {
        JdbcType type = new JdbcType();

        type.setCacheName(cacheName);
        type.setKeyType(String.class);
        type.setValueType("cl.falabella.pnigam.model.Country");
        type.setDatabaseSchema("public");
        type.setDatabaseTable("country");

        type.setKeyFields(new JdbcTypeField(Types.CHAR, "code", String.class, "code"));

        type.setValueFields(
            new JdbcTypeField(Types.VARCHAR, "name", String.class, "name"),
            new JdbcTypeField(Types.VARCHAR, "continent", String.class, "continent"),
            new JdbcTypeField(Types.VARCHAR, "region", String.class, "region"),
            new JdbcTypeField(Types.REAL, "surfacearea", double.class, "surfacearea"),
            new JdbcTypeField(Types.SMALLINT, "indepyear", Short.class, "indepyear"),
            new JdbcTypeField(Types.INTEGER, "population", int.class, "population"),
            new JdbcTypeField(Types.REAL, "lifeexpectancy", Double.class, "lifeexpectancy"),
            new JdbcTypeField(Types.NUMERIC, "gnp", BigDecimal.class, "gnp"),
            new JdbcTypeField(Types.NUMERIC, "gnpold", BigDecimal.class, "gnpold"),
            new JdbcTypeField(Types.VARCHAR, "localname", String.class, "localname"),
            new JdbcTypeField(Types.VARCHAR, "governmentform", String.class, "governmentform"),
            new JdbcTypeField(Types.VARCHAR, "headofstate", String.class, "headofstate"),
            new JdbcTypeField(Types.INTEGER, "capital", Integer.class, "capital"),
            new JdbcTypeField(Types.CHAR, "code2", String.class, "code2")
        );

        return type;
    }

    /**
     * Create configuration for cache "CountrylanguageCache".
     * 
     * @return Configured cache.
     * @throws Exception if failed to create cache configuration.
     **/
    public static CacheConfiguration cacheCountrylanguageCache() throws Exception {
        CacheConfiguration ccfg = new CacheConfiguration();

        ccfg.setName("CountrylanguageCache");
        ccfg.setCacheMode(CacheMode.PARTITIONED);
        ccfg.setAtomicityMode(CacheAtomicityMode.ATOMIC);

        CacheJdbcPojoStoreFactory cacheStoreFactory = new CacheJdbcPojoStoreFactory();

        cacheStoreFactory.setDataSourceFactory(new Factory<DataSource>() {
            /** {@inheritDoc} **/
            @Override public DataSource create() {
                return DataSources.INSTANCE_dsPostgreSQL_World;
            };
        });

        cacheStoreFactory.setDialect(new BasicJdbcDialect());

        cacheStoreFactory.setTypes(jdbcTypeCountrylanguage(ccfg.getName()));

        ccfg.setCacheStoreFactory(cacheStoreFactory);

        ccfg.setReadThrough(true);
        ccfg.setWriteThrough(true);

        ArrayList<QueryEntity> qryEntities = new ArrayList<>();

        QueryEntity qryEntity = new QueryEntity();

        qryEntity.setKeyType("cl.falabella.pnigam.model.CountrylanguageKey");
        qryEntity.setValueType("cl.falabella.pnigam.model.Countrylanguage");

        HashSet<String> keyFields = new HashSet<>();

        keyFields.add("countrycode");

        keyFields.add("language");

        qryEntity.setKeyFields(keyFields);

        LinkedHashMap<String, String> fields = new LinkedHashMap<>();

        fields.put("countrycode", "java.lang.String");
        fields.put("language", "java.lang.String");
        fields.put("isofficial", "java.lang.Boolean");
        fields.put("percentage", "java.lang.Double");

        qryEntity.setFields(fields);
        qryEntities.add(qryEntity);

        ccfg.setQueryEntities(qryEntities);

        return ccfg;
    }

    /**
     * Create JDBC type for "jdbcTypeCountrylanguage".
     * 
     * @param cacheName Cache name.
     * @return Configured JDBC type.
     **/
    private static JdbcType jdbcTypeCountrylanguage(String cacheName) {
        JdbcType type = new JdbcType();

        type.setCacheName(cacheName);
        type.setKeyType("cl.falabella.pnigam.model.CountrylanguageKey");
        type.setValueType("cl.falabella.pnigam.model.Countrylanguage");
        type.setDatabaseSchema("public");
        type.setDatabaseTable("countrylanguage");

        type.setKeyFields(
            new JdbcTypeField(Types.CHAR, "countrycode", String.class, "countrycode"),
            new JdbcTypeField(Types.VARCHAR, "language", String.class, "language")
        );

        type.setValueFields(
            new JdbcTypeField(Types.BIT, "isofficial", boolean.class, "isofficial"),
            new JdbcTypeField(Types.REAL, "percentage", double.class, "percentage")
        );

        return type;
    }
}