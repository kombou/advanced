package org.orion.app.extractor.contract;

import java.util.Map;

public interface IExtractor<T> {

    T getModel(Map<String, String[]> parameters);
}
