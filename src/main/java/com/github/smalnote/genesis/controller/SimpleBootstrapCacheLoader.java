package com.github.smalnote.genesis.controller;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;

public class SimpleBootstrapCacheLoader implements BootstrapCacheLoader{
    public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException();
    }

	@Override
	public void load(Ehcache cache) throws CacheException {
		cache.put(new Element("simple", new Greeting(2, "simple")));
	}

	@Override
	public boolean isAsynchronous() {
		// TODO Auto-generated method stub
		return false;
	}

}
