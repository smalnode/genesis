package com.github.smalnote.genesis.controller;

import java.util.Properties;

import net.sf.ehcache.bootstrap.BootstrapCacheLoaderFactory;

public class SimpleBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactory<SimpleBootstrapCacheLoader> {

	@Override
	public SimpleBootstrapCacheLoader createBootstrapCacheLoader(Properties properties) {
		return new SimpleBootstrapCacheLoader();
	}

}
