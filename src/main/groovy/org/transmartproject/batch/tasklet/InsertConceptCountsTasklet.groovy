package org.transmartproject.batch.tasklet

import java.sql.PreparedStatement
import java.sql.SQLException

/**
 * Inserts the concept counts from a study, based on the already inserted observation facts</br>
 * This will insert counts for all kinds of leaf concepts (both lowdim and highdim)
 */
abstract class InsertConceptCountsTasklet extends GenericTableUpdateTasklet {

    @Override
    void setValues(PreparedStatement ps) throws SQLException {
        ps.setString(1, studyId)
    }

    /**
     * @return Insert query
     */
    abstract String getSql()
}
