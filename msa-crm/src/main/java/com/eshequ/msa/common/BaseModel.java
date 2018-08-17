/**
 * 
 */
package com.eshequ.msa.common;

import javax.persistence.Transient;

/**
 * @author davidhardson
 *
 */
public class BaseModel {

	  @Transient
	    private Integer page = 1;

	    @Transient
	    private Integer rows = 10;

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public Integer getRows() {
			return rows;
		}

		public void setRows(Integer rows) {
			this.rows = rows;
		}
	    
	    

}