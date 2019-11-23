package com.first1444.dashboard

class ActiveComponentMultiplexer(
        override val title: String,
        components: Collection<ActiveComponent>
) : ActiveComponent {
    private val activeComponents = components.toList()

    override fun update() {
        for(component in activeComponents){
            component.update()
        }
    }

    override fun onRemove() {
        for(component in activeComponents){
            component.onRemove()
        }
    }


}
