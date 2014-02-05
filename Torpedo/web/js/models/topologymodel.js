/*
   Copyright 2012 IBM

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

window.Topology = Backbone.Model.extend({

	url:"/wm/topology/links/json",

	defaults:{
		nodes: [],
		links: [],
	},

//	callbacks: {},
//
//	on: function(event, callback, context) {
//		if ( !this.callbacks[event] ) {
//			this.callbacks[event] = [];
//		}
//		this.callbacks[event].push( callback );
//
//		Backbone.Model.prototype.on.call(this, event, callback, context);
//	},

	initialize: function() {
		var self = this;

		$.ajax({
			url:hackBase + self.url,
			dataType:"json",
			success:function (data) {
				self.nodes = [];
				self.links = [];

				// step 1: build unique array of switch IDs
				/* this doesn't work if there's only one switch,
                   because there are no switch-switch links
                _.each(data, function (l) {
                    self.nodes[l['src-switch']] = true;
                    self.nodes[l['dst-switch']] = true;
                });
                // console.log(self.nodes);
                var nl = _.keys(self.nodes);
				 */
				swl = iris.switchCollection;

				var nl = swl.pluck('id');
				self.nodes = _.map(nl, function (n) {return {name:n}});

				// step 2: build array of links in format D3 expects
//				console.log(data);
				_.each(data, function (l) {
					self.links.push({source:nl.indexOf(l['src-switch']),
						target:nl.indexOf(l['dst-switch']),
						value:10});
				});
				
				/*
				if ( data.length <= 0 ) {
					self.nodes = [];
					self.links = [];
				}
				*/

				self.trigger('change');
				//self.set(data);
			}
		});
	},

	fetch:function () {
		this.initialize();
	}

});