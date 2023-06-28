// Comandos MongoDB - Inserção dos dados
db.clients.insertOne({
  "id": 2,
  "nome": "Chico",
  "endereco": "Rua Torres, 74",
  "telefone": "(51) 98789-5543"
})

db.pedidos.insertOne({
  "id": 2,
  "id_cliente": 2,
  "data_hora": ISODate("2023-11-23T22:02:00"),
  "tipo_entrega": "delivery",
  "total": 37.75
})

db.pizzas.insertOne({
  "id": 2,
  "nome": "Portuguesa",
  "tamanho": "Grande",
  "preco": 35.00
})

db.bebidas.insertOne({
  "id": 2,
  "nome": "Pepsi",
  "preco": 5.00
})

db.itens_pedido.insertOne({
  "id": 2,
  "id_pedido": 2,
  "id_pizza": 2,
  "quantidade": 2
})



// Atualização dos dados:
db.clients.updateOne(
  { "id": 2 },
  { $set: { "endereco": "Av Beira Mar, 456" } }
)

db.pedidos.updateOne(
  { "id": 1 },
  { $set: { "tipo_entrega": "delivery" } }
)

db.pizzas.updateOne(
  { "id": 2 },
  { $set: { "preco": 47.50 } }
)

db.bebidas.updateOne(
  { "id": 2 },
  { $set: { "preco": 4.99 } }
)

db.itens_pedido.updateOne(
  { "id": 2 },
  { $set: { "quantidade": 3 } }
)



// Exclusão dos dados:
db.clients.deleteOne({ "id": 1 })
db.pedidos.deleteOne({ "id": 1 })
db.pizzas.deleteOne({ "id": 1 })
db.bebidas.deleteOne({ "id": 1 })
db.itens_pedido.deleteOne({ "id": 1 })


// Consulta Simples:
db.pizzas.find()

// Consulta com Condição:
db.pedidos.find({ "tipo_entrega": "delivery" })


// Consulta usando Aggregate (join):
db.pedidos.aggregate([
  {
    $lookup: {
      from: "clients",
      localField: "id_cliente",
      foreignField: "id",
      as: "cliente"
    }
  },
  { $unwind: "$cliente" }
])


// Consulta usando Aggregate (group by):
db.itens_pedido.aggregate([
  {
    $group: {
      _id: "$id_pizza",
      totalVendido: { $sum: "$quantidade" }
    }
  }
])