package org.transmartproject.batch.highdim.assays

import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.transmartproject.batch.concept.ConceptNode
import org.transmartproject.batch.concept.ConceptPath
import org.transmartproject.batch.concept.ConceptTree

/**
 * Maps {@link MappingFileRow}s to {@link ConceptNode}s by using the
 * {@link ConceptTree}.
 */
@Component
@JobScope
class MappingFileRowToConceptMapper {

    @Value("#{jobParameters['TOP_NODE']}")
    private ConceptPath topNode

    @Value("#{jobParameters['NODE_NAME']}")
    private String nodeName

    @Autowired
    private ConceptTree conceptTree

    ConceptNode getAt(MappingFileRow row) {
        ConceptPath conceptPath = nodeName ?
                topNode + nodeName + row.conceptFragment
                : topNode + row.conceptFragment

        conceptTree[conceptPath]
    }
}
