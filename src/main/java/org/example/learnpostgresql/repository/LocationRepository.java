package org.example.learnpostgresql.repository;

import org.example.learnpostgresql.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
    @Query(value = """
        SELECT * FROM location
        WHERE ST_DWithin(
          coordinates::geography,
          ST_SetSRID(ST_MakePoint(:lng, :lat), 4326)::geography,
          :radius
        )
        """, nativeQuery = true)
    List<Location> findNearby(
            @Param("lng") double longitude,
            @Param("lat") double latitude,
            @Param("radius") double radiusInMeters
    );
}
