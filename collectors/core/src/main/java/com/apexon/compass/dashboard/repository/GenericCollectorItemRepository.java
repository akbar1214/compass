package com.apexon.compass.dashboard.repository;

import com.apexon.compass.dashboard.model.Build;
import com.apexon.compass.dashboard.model.GenericCollectorItem;
import org.bson.types.ObjectId;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository for {@link Build} data.
 */
public interface GenericCollectorItemRepository
		extends CrudRepository<GenericCollectorItem, ObjectId>, QuerydslPredicateExecutor<GenericCollectorItem> {

	List<GenericCollectorItem> findAllByToolName(String toolName);

	List<GenericCollectorItem> findAllByRelatedCollectorItem(ObjectId relatedCollectorItemId);

	GenericCollectorItem findByToolNameAndRawDataAndRelatedCollectorItem(String toolName, String rawData,
			ObjectId relatedCollectorItem);

	List<GenericCollectorItem> findAllByToolNameAndProcessTimeEquals(String toolName, long processTime);

}
