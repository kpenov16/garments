(ns garments.agents)


(defn agents
  []
  (def amount (agent 100))
  (println @amount)
  (send amount inc)
  (println @amount)
  (println "some time has passed")
  (println @amount)

  (send amount inc)
  (await-for 1000 amount)
  (println @amount)

  (println (agent-error amount))
  )
(agents)