package com.codeu.team51.crawl.Redis;

import com.lexicalscope.jewel.cli.Option;

public interface Cli {

	/**
	* Gets a single term to search
	*/
	@Option
	String getTerm();
	
	@Option
	String getFilter();
}
