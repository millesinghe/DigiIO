package com.digio.processor;

import com.digio.model.LogObj;

import java.util.List;

public abstract class AbstractLogProcessor<T> {

   public abstract void setArgs(Object ... args );

   public abstract T execute(List<LogObj> logs );
}
