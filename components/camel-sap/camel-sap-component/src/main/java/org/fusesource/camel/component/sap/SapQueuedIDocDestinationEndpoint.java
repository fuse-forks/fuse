/**
 * Copyright 2014 Red Hat, Inc.
 * 
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 * 
 */
package org.fusesource.camel.component.sap;

import org.apache.camel.Producer;
import org.apache.camel.spi.UriEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an SAP endpoint sending a IDoc (Intermediary Document) to an SAP system using the queued remote function call.
 * 
 * @author William Collins <punkhornsw@gmail.com>
 *
 */
@UriEndpoint(scheme="sap-qidoc-destination")
public class SapQueuedIDocDestinationEndpoint extends SapIDocDestinationEndpoint {

	private static final Logger LOG = LoggerFactory.getLogger(SapQueuedIDocDestinationEndpoint.class); 

    protected String queueName;

    public SapQueuedIDocDestinationEndpoint() {
	}

	public SapQueuedIDocDestinationEndpoint(String endpointUri, SapQueuedIDocDestinationComponent component) {
		super(endpointUri, component);
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	@Override
	public Producer createProducer() throws Exception {
		LOG.debug("Created producer for endpoint '" + getEndpointUri() + "'");
		return new SapQueuedIDocProducer(this);
	}

}
