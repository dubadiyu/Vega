/*******************************************************************************
 * Copyright (c) 2011 Subgraph.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Subgraph - initial API and implementation
 ******************************************************************************/
package com.subgraph.vega.api.model.alerts;

import java.util.List;

import com.subgraph.vega.api.events.IEventHandler;

public interface IScanAlertRepository {
	final static int PROXY_ALERT_ORIGIN_SCAN_ID = -1;
	IScanInstance addActiveScanInstanceListener(IEventHandler listener);
	void removeActiveScanInstanceListener(IEventHandler listener);
	void setActiveScanInstance(IScanInstance scanInstance);
	IScanInstance getActiveScanInstance();
	List<IScanInstance> getAllScanInstances();
	IScanInstance createNewScanInstance();
	IScanInstance getScanInstanceByScanId(long scanId);
	IScanInstance getProxyScanInstance();
}
