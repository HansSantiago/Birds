package com.co.ias.Birds.infraestructure.adapters.output;

import com.co.ias.Birds.infraestructure.models.SpeciesDAO;
import com.co.ias.Birds.species.aplication.domain.Species;
import com.co.ias.Birds.species.aplication.domain.valueObjs.SpeciesId;
import com.co.ias.Birds.species.aplication.ports.output.SpeciesRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgresSqlSpeciesRepository implements SpeciesRepository {

    private final DataSource dataSource;

    public PostgresSqlSpeciesRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void store(Species species) {
        String sql = "INSERT INTO species (name, country, description) values (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, species.getName().getValue());
            preparedStatement.setString(2, species.getCountry().getValue());
            preparedStatement.setString(1, species.getDescription().getValue());
        } catch (SQLException exception) {
            throw new RuntimeException("Error queryng database", exception);
        }
    }


    @Override
    public Optional<Species> get(SpeciesId speciesId) {
        String sql = "Select * from species where id = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
            preparedStatement.setString(1, speciesId.toString());

            ResultSet resultSet =preparedStatement.executeQuery();

            if (resultSet.next()) {
                SpeciesDAO speciesDAO = SpeciesDAO.fromResultSet(resultSet);

                Species species = speciesDAO.toDomain();
                return Optional.of(species);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {
            throw new RuntimeException("Error queryng database", exception);
        }
    }

    @Override
    public void update(Species species) {

    }

    @Override
    public Boolean delete(SpeciesId speciesId) {
        return null;
    }
}
