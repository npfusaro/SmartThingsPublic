/**
 *  Door Unlock By
 *
 *  
 *
 */
definition(
    name: "Door Unlocked By",
    namespace: "Fuzzosaurus",
    author: "Fuzzosaurus",
    description: "Sends push message when door is unlocked using a code",
    category: "Safety & Security",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

import groovy.json.JsonSlurper

preferences {
	section("Choose Locks") {
		input "lock1", "capability.lock", multiple: true
        input("username1", "text", title: "Username 1", required: false, description: "Enter Identifier for lock UserID Code, Leave blank to not recieve notification for this code")
        input("username2", "text", title: "Username 2", required: false, description: "Enter Identifier for lock UserID Code, Leave blank to not recieve notification for this code")
        input("username3", "text", title: "Username 3", required: false, description: "Enter Identifier for lock UserID Code, Leave blank to not recieve notification for this code")
        input("username4", "text", title: "Username 4", required: false, description: "Enter Identifier for lock UserID Code, Leave blank to not recieve notification for this code")
        input("username5", "text", title: "Username 5", required: false, description: "Enter Identifier for lock UserID Code, Leave blank to not recieve notification for this code")
        input("username6", "text", title: "Username 6", required: false, description: "Enter Identifier for lock UserID Code, Leave blank to not recieve notification for this code")
    }
    
}

def installed() {
    subscribe(lock1, "lock", checkCode)
}

def updated() {
	unsubscribe()
    subscribe(lock1, "lock", checkCode)
}

def checkCode(evt) {
    log.debug "$evt.value: $evt, $settings"

    if(evt.value == "unlocked" && evt.data) {
    
    	def lockData = new JsonSlurper().parseText(evt.data)
     
         
	    switch( lockData.usedCode ){
        case 1: 
        	if(username1 != null ){
        		sendPush "Door unlocked by $username1"
                break
            }
        case 2:
        	if(username2 != null ){
        		sendPush "Door unlocked by $username2"
                break
            }
        case 3:
        	if(username3 != null ){
        		sendPush "Door unlocked by $username3"
                break
            }
        case 4:
        	if(username4 != null ){
        		sendPush "Door unlocked by $username4"
                break
            }
        case 5:
        	if(username5 != null ){
        		sendPush "Door unlocked by $username5"
                break
            }
        case 6:
        	if(username6 != null ){
        		sendPush "Door unlocked by $username6"
                break 
            } 
            lock1.refresh
       
        }    
         
    }
}