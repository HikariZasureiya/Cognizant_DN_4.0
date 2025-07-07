package com.cognizant.orm_learn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cognizant.orm_learn.model.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    public List<Country> findAll();
}