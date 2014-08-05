GoEvent
=======

projeto de referência para uma arquitetura modular baseada em Java EE e OSGi 

Atualmente o projeto conta com os seguintes bundles OSGi:

goevent - projeto raiz
  |
  |____ base_view - bundle WAB (web aplication bundle) raiz da aplicação, contendo templates facelets
  |
  |____ event - projeto raiz do módulo de eventos
        |
        |____ event_api - api do módulo, expondo pacotese contendo o modelo e as interfaces de serviço 
        |                 e também registra o Service de PersistenceContext 
        |
        |____ event_dao - implementa os serviços regirstrados na event_api
        |
        |
        |____ event_view_fragment - pacote do tipo webFragment, conta com os formulários e ManagedBeans JSF do módulo
